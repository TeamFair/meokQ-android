
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.meokq.presentation.R
import com.meokq.presentation.theme.TextBlack


// Set of Material typography styles to start with
val Pretendard = FontFamily(
    Font(R.font.pretendardbold, FontWeight.Bold),
    Font(R.font.pretendardsemibold, FontWeight.SemiBold),
    Font(R.font.pretendardmedium, FontWeight.Medium),
    Font(R.font.pretendardregular, FontWeight.Normal),
)
val CustomTypo = Typography(
    titleLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        color = TextBlack,
        fontSize = 34.sp,
        lineHeight = 41.sp
    ),
    titleMedium= TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 23.sp,
        lineHeight = 27.sp
    ),
    titleSmall= TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    headlineLarge= TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        color = TextBlack,
        fontSize = 16.sp,
        lineHeight = 19.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 15.sp,
        lineHeight = 22.sp
    ),
    labelLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),

    labelMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 12.sp,
        lineHeight = 14.sp
    ),
    labelSmall= TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 10.sp,
        lineHeight = 12.sp
    )

)