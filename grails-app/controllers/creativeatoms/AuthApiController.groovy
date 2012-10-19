package creativeatoms

import creativeatoms.shiro.User
import grails.converters.JSON
import org.apache.shiro.SecurityUtils
import org.apache.shiro.authc.AuthenticationException
import org.apache.shiro.authc.AuthenticationToken
import org.apache.shiro.authc.UsernamePasswordToken
import org.apache.shiro.grails.ConfigUtils

class AuthApiController {

    def shiroSecurityService

    def checkAuth() {
        render(authStatus as JSON)
    }

    def signIn() {
        String username = request.JSON.username
        String password = request.JSON.password
        boolean rememberMe = request.JSON.rememberMe

        def authToken = new UsernamePasswordToken(username, password)

        // Support for "remember me"
        if (rememberMe) {
            authToken.rememberMe = true
        }

        try {
            SecurityUtils.subject.login(authToken)

            checkAuth()
        }
        catch (AuthenticationException ex) {
            render getAuthStatus(error: message(code: "login.failed")) as JSON
        }
    }

    def signUp() {
        String username = request.JSON.username
        String password = request.JSON.password
        User user = new User(username: username, passwordHash: shiroSecurityService.encodePassword(password, username))
        user.save()
        if (user.id) {
            try {
                AuthenticationToken token = new UsernamePasswordToken(username, password)
                SecurityUtils.subject.login(token)
            } catch (AuthenticationException e) {
                println e
            }
        } else {
            render getAuthStatus(errors: user.errors.allErrors*.toString()) as JSON
        }
        checkAuth()
    }

    def signOut() {
        // Log the user out of the application.
        def principal = SecurityUtils.subject?.principal
        SecurityUtils.subject?.logout()

        ConfigUtils.removePrincipal(principal)

        checkAuth()
    }

    private Map<String, ?> getAuthStatus(Map<String, ?> additional = null) {
        Map<String, ?> m = [
                isAuthenticated: SecurityUtils.subject.isAuthenticated(),
                username: SecurityUtils.subject?.principal
        ]
        if (additional) m.putAll(additional)
        m
    }
}
