package creativeatoms

import ru.mirari.infra.image.ImageCropPolicy
import ru.mirari.infra.image.ImageFormat
import ru.mirari.infra.image.ImageHolder
import ru.mirari.infra.image.ImageType

/**
 * @author alari
 * @since 9/2/12 1:06 AM
 */
class AtomImageHolder implements ImageHolder {
    private final String atomId
    public final String imagesPath
    public final String imagesBucket = "mirariimages"

    AtomImageHolder(Object atomId) {
        this.atomId = atomId.toString()
        imagesPath = "i/".concat(atomId.toString())
    }

    @Override
    String getImagesPath() {
        imagesPath
    }

    @Override
    String getImagesBucket() {
        imagesBucket
    }

    @Override
    List<ImageFormat> getImageFormats() {
        DEFAULT_FORMATS
    }

    @Override
    ImageFormat getDefaultImageFormat() {
        IM_STANDARD
    }

    public static final ImageFormat IM_MAX = new ImageFormat("1920*1920", "im-max", ImageCropPolicy.NONE, ImageType.JPG);

    public static final ImageFormat IM_STANDARD = new ImageFormat("980*750", "im-standard", ImageCropPolicy.NONE, ImageType.JPG);

    public static final ImageFormat IM_MEDIUM = new ImageFormat("180*180", "im-medium", ImageCropPolicy.CENTER, ImageType.JPG);
    public static final ImageFormat IM_SMALL = new ImageFormat("120*120", "im-small", ImageCropPolicy.CENTER, ImageType.JPG);
    public static final ImageFormat IM_THUMB = new ImageFormat("90*90", "im-thumb", ImageCropPolicy.CENTER, ImageType.JPG);

    public static final List<ImageFormat> DEFAULT_FORMATS = new ArrayList<ImageFormat>(Arrays.asList(IM_MAX, IM_STANDARD, IM_MEDIUM, IM_SMALL, IM_THUMB));
}
