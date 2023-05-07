package com.ninise.nativeadsjetpackadmob

import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdView

@Composable
fun NativeAdItemViewXML(ad: NativeAd? = null) {
    AndroidView(
        factory = { context ->
            val adView = LayoutInflater.from(context).inflate(R.layout.layout_admob, null) as NativeAdView

            val headlineView = adView.findViewById<TextView>(R.id.primary)
            val ctaView = adView.findViewById<Button>(R.id.cta)
            val icon = adView.findViewById<ImageView>(R.id.icon)
            val secondary = adView.findViewById<TextView>(R.id.secondary)

            adView.headlineView = headlineView
            adView.callToActionView = ctaView
            adView.iconView = icon
            adView.bodyView = secondary

            ad?.let { ad ->
                adView.setNativeAd(ad)

                headlineView.text = ad.body
                ctaView.text = ad.callToAction
                secondary.text = ad.body

                ad.images.first()?.uri.let { uri ->
                    Glide
                        .with(context)
                        .load(uri)
                        .centerCrop()
                        .into(icon);
                }
            }




            adView
        },
        update = {  },
        modifier = Modifier.height(90.dp)
    )
}