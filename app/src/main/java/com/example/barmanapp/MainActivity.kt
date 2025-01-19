package com.example.barmanapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.barmanapp.ui.theme.BarmanAppTheme
import com.example.barmanapp.ui.theme.LightBlue
import androidx.compose.foundation.lazy.items

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val drinks = listOf("Cuba libre", "Sex on the beach",
            "Mojito", "Manhattan", "Long island", "Gin tonic")

        enableEdgeToEdge()
        setContent {
            BarmanAppTheme {
                Scaffold(modifier = Modifier
                    .width(200.dp)) { innerPadding ->
                    Greeting(
                        name = "Witaj w barze",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                Scaffold(modifier = Modifier
                    .size(200.dp, 300.dp)
                    .offset(0.dp, 100.dp)
                    ) { innerPadding ->
                    ScrollBoxes(
                        modifierScrollBox = Modifier.padding(innerPadding),
                        drinks = drinks
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BarmanAppTheme {
        Greeting("Witaj w barze!")
    }
}

@Composable
private fun ScrollBoxes(modifierScrollBox: Modifier = Modifier,
                        drinks: List<Any> = List(6){"$it"})
    {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .background(LightBlue)
            .size(300.dp, 100.dp)
    ) {
        items(drinks) {
            item -> Text(item as String, modifier = Modifier.padding(2.dp)
                    .clickable {
                        Toast.makeText(context, item, Toast.LENGTH_LONG).show()
                    })
        }
    }
}
