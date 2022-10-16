package com.example.composesample

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composesample.data.Message
import com.example.composesample.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // composable 호출되는 Activity의 layout을 정의한다.
        setContent {
           ComposeSampleTheme {
               Surface (modifier = Modifier.fillMaxSize()) {
                   MessageCard(
                       Message(
                           author = "jinkweonKo",
                           body = "JetPack Compose"
                       )
                   )
               }
           }
        }
    }
}

// Modifier를 사용해서 수정한다.
@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contact Profile Picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        
        // image와 Column 사이의 space를 추가한다.
        Spacer(modifier = Modifier.width(8.dp))
        
        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )

            Spacer(modifier = Modifier.height(4.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }
}


@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
/**
 *  preview가 달린 것은 어디에서도 호출되지 않는다.
 *  @Preview 를 사용해면, 옆에 미리보기 창이 생성된다.
 */
@Preview
@Composable
fun PreviewMessageCard() {
    ComposeSampleTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MessageCard(
                Message("Colleague", "Hey, Take a look at JetPack Compose")
            )
        }
    }
}