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
    //title
    titleLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        color = TextBlack,
        fontSize = 23.sp,
        lineHeight = 24.sp
    ), titleMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 22.sp,
        lineHeight = 17.sp
    ),
    //heading
    headlineLarge = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Medium,
        color = TextBlack,
        fontSize = 19.sp,
        lineHeight = 23.sp
    ), headlineMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        color = TextBlack,
        fontSize = 17.sp,
        lineHeight = 20.sp
    ), headlineSmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Bold,
        color = TextBlack,
        fontSize = 15.sp,
        lineHeight = 18.sp
    ),

    //body
    bodySmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        color = TextBlack,
        fontSize = 15.sp,
        lineHeight = 22.sp
    ),
    //caption
    labelMedium = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        color = TextBlack,
        fontSize = 13.sp,
        lineHeight = 20.sp
    ), labelSmall = TextStyle(
        fontFamily = Pretendard,
        fontWeight = FontWeight.Normal,
        color = TextBlack,
        fontSize = 12.sp,
        lineHeight = 18.sp
    )
)
val Subtitle01 = CustomTypo.headlineMedium.copy(
    fontSize = 16.sp, lineHeight = 24.sp, fontWeight = FontWeight.SemiBold
)
val Subtitle02 = Subtitle01.copy(fontWeight = FontWeight.Normal)
val Button = CustomTypo.bodyLarge.copy(
    fontSize = 16.sp,
    lineHeight = 18.sp,
)
val TabBold = CustomTypo.headlineLarge.copy(
    fontSize = 14.sp,
    lineHeight = 24.sp,
)
val TabRegular = TabBold.copy(
    fontWeight = FontWeight.Normal
)
val Badge01 = CustomTypo.bodyLarge.copy(
    fontSize = 10.sp, lineHeight = 12.sp, color = TextBlack
)
val Badge02 = TabRegular.copy(
    fontSize = 10.sp, lineHeight = 12.sp, color = TextBlack
)

