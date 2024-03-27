package belajar.p2.recyle_view

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import belajar.p2.recyle_view.data.Data_Source
import belajar.p2.recyle_view.data.Mahasiswa
import belajar.p2.recyle_view.ui.theme.ReplyTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReplyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    run_App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun run_App() {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Daftar Mahasiswa Kelas 4C")})}
    ){
        Column(
            modifier = Modifier
                .padding(top= 70.dp)
        ){
            adapter()
        }
    }
}
@SuppressLint("SuspiciousIndentation")
@Composable
fun Listdata(model: Mahasiswa) {
    val context = LocalContext.current

        OutlinedCard(elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .clickable {
                            val intent_tujuan = Intent(context,ProfileDetail::class.java)
                            intent_tujuan.putExtra("Test", model)
                            context.startActivity(intent_tujuan)

                        }
                ){
                    Image(
                        painter = painterResource(id = model.image), contentDescription = "",
                        modifier = Modifier
                            .size(100.dp)
                            .padding(15.dp)
                            .clickable {

                            }
                    )
                    Column(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = model.nama,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Text(text = model.nim)

                    }
                }
            }
        }
}
@Composable
fun adapter() {
    val list_mahasiswa = remember {
        Data_Source.mahasiswa_list
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {  }
    ){
        items(
            items = list_mahasiswa,
            itemContent = { Listdata(model = it)}
        )
    }
}
@Preview
@Composable
fun prev() {
    ReplyTheme(darkTheme = false){
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            run_App()
        }
    }
}
@Preview
@Composable
fun prev2() {
    ReplyTheme(darkTheme = true){
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            run_App()
        }
    }
}