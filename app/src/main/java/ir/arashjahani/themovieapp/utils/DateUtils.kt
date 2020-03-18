package ir.arashjahani.themovieapp.utils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

/**
 * Created By ArashJahani on 2020/03/17
 */

fun String.getYear():String{
    return LocalDate.parse(this).year.toString()

}