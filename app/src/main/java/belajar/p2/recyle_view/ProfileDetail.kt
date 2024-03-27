package belajar.p2.recyle_view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import belajar.p2.recyle_view.data.Mahasiswa
import belajar.p2.recyle_view.ui.theme.ReplyTheme

@Suppress("DEPRECATION")
class ProfileDetail : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReplyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val modelTe = intent.getSerializableExtra("Test") as Mahasiswa
                    val nama = modelTe.nama
                    val nim = modelTe.nim
                    val image = modelTe.image
//                    Scaffold {
//                        var modelTe = intent.getSerializableExtra("Test") as Mahasiswa
//                        var nama = modelTe.nama
//                        var nim = modelTe.nim
//                        var image = modelTe.image
//                        Column {
//                            Image(
//                                painter = painterResource(id = image),
//                                contentDescription = null
//                            )
//                            Text(text = nama)
//                        }
//
//                    }
                    Prev(nama = nama, nim = nim, image = image )
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Prev(nama: String, nim:String, image: Int) {
    ReplyTheme {
        Scaffold {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(120.dp)
                    .padding(vertical = 30.dp)
                ,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(300.dp)
                )

                    Text(text = nama,
                        modifier = Modifier
                            .padding(top = 30.dp),
                        fontSize = 30.sp
                    )
                    Text(text = nim,
                        modifier = Modifier
                            .padding(top = 16.dp),
                        fontSize = 30.sp
                    )

            }

        }

    }

}
@Preview(showBackground = true)
@Composable
fun Prev3() {
    Prev(nama = "farhan", nim = "1111111", image = R.drawable.saya )
}
