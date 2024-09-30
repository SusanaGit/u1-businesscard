package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
private fun BusinessCard() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        BackgroundImage()

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row() {
                CenterInformation()
            }
            Row {
                ContactInformation()
            }
        }
    }
}

@Composable
private fun CenterInformation() {
    Column(
        modifier = Modifier
            .padding(top = 250.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(){
            Logo()
        }
        Row(){
            Text(
                text = stringResource(R.string.susana_figueroa),
                fontSize = 35.sp
            )
        }
        Row(){
            Text(
                text = stringResource(R.string.manekineko),
                fontSize = 30.sp,
                color = Color(0xFF66ADE6)
            )
        }
    }
}

@Composable
private fun Logo() {
    val logo = painterResource(R.drawable.logo)
    Image(
        painter = logo,
        contentDescription = "logo",
        modifier = Modifier
            .height(150.dp)
            .width(150.dp)
            .clip(CircleShape)
    )
}

@Composable
private fun ContactInformation() {
    Column(
        modifier = Modifier
            .padding(top = 150.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = stringResource(R.string.telf),
                tint = Color(0xFF66ADE6)
            )
            Text(
                text = stringResource(R.string.telf)
            )
        }
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = stringResource(R.string.susanagit),
                tint = Color(0xFF66ADE6)
            )
            Text(
                text = stringResource(R.string.susanagit)
            )

        }
        Row(
            modifier = Modifier
                .padding(10.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = stringResource(R.string.mail),
                tint = Color(0xFF66ADE6)
            )
            Text(
                text = stringResource(R.string.mail)
            )
        }
    }
}

@Composable
private fun BackgroundImage() {
    val imagebackground = painterResource(R.drawable.background_image)
    Image(
        painter = imagebackground,
        contentDescription = "imagebackground",
        modifier = Modifier
            .fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}