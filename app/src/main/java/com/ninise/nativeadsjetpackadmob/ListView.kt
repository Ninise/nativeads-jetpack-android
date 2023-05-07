package com.ninise.nativeadsjetpackadmob

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.android.gms.ads.nativead.NativeAd

@Composable
fun ListScreen(ads: List<NativeAd>) {

    var list: List<String> = listOf("PEPE","FLOKI","ELON","TURBO","SHIB")


    ListContent(
        list = list,
        ads = ads
    )

}

@Composable
fun ListContent(list: List<String>, ads: List<NativeAd>) {

    Box(modifier =
    Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center,
    ) {
        Column(modifier = Modifier.fillMaxSize()) {

            LazyColumn(modifier = Modifier.padding(horizontal = 20.dp)) {

                itemsIndexed(list) { index, item ->

                    Text(text = item)

                    Spacer(modifier = Modifier.height(4.dp))

                    Divider(startIndent = 2.dp, thickness = 1.dp, color = Color.Black)

                    Spacer(modifier = Modifier.height(4.dp))

                    if (index % 3 == 0 && ads.isNotEmpty()) {
                        NativeAdItemViewXML(ad = ads.random())

                        Spacer(modifier = Modifier.height(4.dp))

                        Divider(startIndent = 2.dp, thickness = 1.dp, color = Color.Black)

                        Spacer(modifier = Modifier.height(4.dp))
                    }

                }



            }
        }
    }
}