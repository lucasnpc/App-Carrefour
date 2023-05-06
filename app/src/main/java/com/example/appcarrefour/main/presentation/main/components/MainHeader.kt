package com.example.appcarrefour.main.presentation.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.appcarrefour.R
import com.example.appcarrefour.utils.Dimen48dp
import com.example.appcarrefour.utils.Dimen80dp
import com.example.appcarrefour.utils.Font24sp

@Composable
fun MainHeader() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = Dimen80dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = stringResource(id = R.string.person_icon_description),
            modifier = Modifier
                .width(Dimen48dp)
                .height(Dimen48dp),
            tint = Color.White
        )
        Text(text = "Carrefour", color = Color.White, fontSize = Font24sp)
    }
}