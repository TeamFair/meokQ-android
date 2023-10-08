import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.meokq.presentation.R
import com.meokq.presentation.theme.MeokQTypography


// Set of Material typography styles to start with
val Pretendard = FontFamily(
    Font(R.font.pretendardbold, FontWeight.Bold),
    Font(R.font.pretendardsemibold, FontWeight.SemiBold),
    Font(R.font.pretendardmedium, FontWeight.Medium),
    Font(R.font.pretendardregular, FontWeight.Normal),
)

val defaultMeokQTypography = MeokQTypography(
    Title01 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    Title02 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = 0.sp
    ),
    Heading01 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 17.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.4).sp
    ),
    Heading02 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        lineHeight = 18.sp,
        letterSpacing = (-0.4).sp
    ),
    Heading03 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        fontSize = 19.sp,
        lineHeight = 23.sp,
        letterSpacing = (-0.4).sp
    ),
    Subtitle01 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.4).sp
    ),
    Subtitle02 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = (-0.4).sp
    ),
    Caption01 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        lineHeight = 20.sp,
        letterSpacing = (-0.3).sp
    ),
    Caption02 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = (-0.3).sp
    ),
    Body = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.3).sp
    ),
    Button = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp
    ),
    TabBold = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    TabRegular = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    Badge01 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.sp
    ),
    Badge02 = TextStyle(
        color = Color.Black,
        fontFamily = Pretendard,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp,
        lineHeight = 12.sp,
        letterSpacing = (-0.3).sp
    )
)