package belajar.p2.recyle_view.data

import android.media.Image
import android.provider.MediaStore.Images
import java.io.Serializable

data class Mahasiswa(
    val image:Int =0,
    val nama:String,
    val nim: String,
) : Serializable