package cz.matej.clashroyaleapp.binding;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class BindingAdapters
{
	@BindingAdapter({"imageUrl"})
	public static void loadImage(ImageView imageView, String imageUrl)
	{
		Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
	}
}
