package ir.arashjahani.themovieapp

import android.text.format.DateUtils
import ir.arashjahani.themovieapp.utils.getYear
import org.junit.Test
import org.junit.Assert.*


/**
 * Created By ArashJahani on 2020/03/18
 */
class DateConvertorUnitTest {

    @Test fun isCorrect(){

        assertEquals("1992","1992-12-05".getYear())

        assertEquals("2000","2000-01-01".getYear())

    }


}