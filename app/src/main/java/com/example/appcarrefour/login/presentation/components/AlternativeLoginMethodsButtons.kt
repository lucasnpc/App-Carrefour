package com.example.appcarrefour.login.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.appcarrefour.R
import com.example.appcarrefour.ui.theme.PrimaryDark

@Composable
fun AlternativeLoginMethodsButtons(){
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(1.dp, PrimaryDark),
            modifier = Modifier.width(100.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = stringResource(
                    R.string.google_icon_description
                ),
                tint = PrimaryDark
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            border = BorderStroke(1.dp, PrimaryDark),
            modifier = Modifier.width(100.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = stringResource(
                    R.string.facebook_icon_description
                ),
                tint = PrimaryDark
            )
        }
    }
}