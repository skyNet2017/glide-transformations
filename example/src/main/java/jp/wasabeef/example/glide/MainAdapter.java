package jp.wasabeef.example.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import java.util.List;
import jp.wasabeef.glide.transformations.*;
import jp.wasabeef.glide.transformations.CropTransformation.CropType;
import jp.wasabeef.glide.transformations.gpu.*;
import jp.wasabeef.glide.transformations.internal.Utils;

/**
 * Created by Wasabeef on 2015/01/11.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private Context context;
    private List<Type> dataSet;

    public enum Type {
        Mask,
        NinePatchMask,
        CropTop,
        CropCenter,
        CropBottom,
        CropSquare,
        CropCircle,
        CropCircleWithBorder,
        ColorFilter,
        Grayscale,
        RoundedCorners,
        BlurLight,
        BlurDeep,
        Toon,
        Sepia,
        Contrast,
        Invert,
        Pixel,
        Sketch,
        Swirl,
        Brightness,
        Kuawahara,
        Vignette
    }

    public MainAdapter(Context context, List<Type> dataSet) {
        this.context = context;
        this.dataSet = dataSet;
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int dp266 = (int) Ext.getPx(266);
        int dp252 = (int) Ext.getPx(252);
        int dp300 = (int) Ext.getPx(300);
        int dp200 = (int) Ext.getPx(200);
        int dp100 = (int) Ext.getPx(100);
        int dp120 = (int) Ext.getPx(120);

        switch (dataSet.get(position)) {
            case Mask:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.overrideOf(dp266, dp252))
                        .apply(RequestOptions.bitmapTransform(
                                new MultiTransformation<Bitmap>(new CenterCrop(),
                                        new MaskTransformation(R.drawable.mask_starfish))))
                        .into(holder.image);
                break;

            case NinePatchMask:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.overrideOf(dp300, dp200))
                        .apply(RequestOptions.bitmapTransform(
                                new MultiTransformation<Bitmap>(new CenterCrop(),
                                        new MaskTransformation(R.drawable.mask_chat_right))))
                        .into(holder.image);
                break;

            case CropTop:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new CropTransformation(dp300, dp100, CropType.TOP)))
                        .into(holder.image);
                break;

            case CropCenter:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new CropTransformation(dp300, dp100, CropType.CENTER)))
                        .into(holder.image);
                break;

            case CropBottom:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new CropTransformation(dp300, dp100, CropType.BOTTOM)))
                        .into(holder.image);
                break;

            case CropSquare:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropSquareTransformation()))
                        .into(holder.image);
                break;

            case CropCircle:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new CropCircleTransformation()))
                        .into(holder.image);
                break;

            case CropCircleWithBorder:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new CropCircleWithBorderTransformation(Utils.toDp(4),
                                        Color.rgb(0, 145, 86))))
                        .into(holder.image);
                break;

            case ColorFilter:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new ColorFilterTransformation(Color.argb(80, 255, 0, 0))))
                        .into(holder.image);
                break;

            case Grayscale:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new GrayscaleTransformation()))
                        .into(holder.image);
                break;

            case RoundedCorners:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(
                                new RoundedCornersTransformation(dp120, 0,
                                        RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT)))
                        .into(holder.image);
                break;

            case BlurLight:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new BlurTransformation(25)))
                        .into(holder.image);
                break;

            case BlurDeep:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 8)))
                        .into(holder.image);
                break;

            case Toon:
                Glide.with(context)
                        .load(R.drawable.demo)
                        .apply(RequestOptions.bitmapTransform(new ToonFilterTransformation()))
                        .into(holder.image);
                break;

            case Sepia:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new SepiaFilterTransformation()))
                        .into(holder.image);
                break;

            case Contrast:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new ContrastFilterTransformation(2.0f)))
                        .into(holder.image);
                break;

            case Invert:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new InvertFilterTransformation()))
                        .into(holder.image);
                break;

            case Pixel:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new PixelationFilterTransformation(20f)))
                        .into(holder.image);
                break;

            case Sketch:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(new SketchFilterTransformation()))
                        .into(holder.image);
                break;

            case Swirl:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new SwirlFilterTransformation(0.5f, 1.0f, new PointF(0.5f, 0.5f)))
                                .dontAnimate())
                        .into(holder.image);
                break;

            case Brightness:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new BrightnessFilterTransformation(0.5f)).dontAnimate())
                        .into(holder.image);
                break;

            case Kuawahara:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new KuwaharaFilterTransformation(25)).dontAnimate())
                        .into(holder.image);
                break;

            case Vignette:
                Glide.with(context)
                        .load(R.drawable.check)
                        .apply(RequestOptions.bitmapTransform(
                                new VignetteFilterTransformation(new PointF(0.5f, 0.5f),
                                        new float[]{0.0f, 0.0f, 0.0f}, 0f, 0.75f)).dontAnimate())
                        .into(holder.image);
                break;
        }
        holder.title.setText(dataSet.get(position).name());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
        }
    }
}