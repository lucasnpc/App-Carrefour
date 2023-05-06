package com.example.appcarrefour.login.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.appcarrefour.R

@Composable
fun CarrefourIcon(){
    Image(
        painter = painterResource(id = R.drawable.carrefour),
        contentDescription = stringResource(
            R.string.carrefour_logo_description
        ),
        modifier = Modifier
            .width(195.dp)
            .height(38.dp)
    )
}