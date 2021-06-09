package io.legado.app.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.legado.app.R
import kotlinx.parcelize.Parcelize

@Entity(tableName = "book_line")
@Parcelize
data class DrawLineEntity(

    @PrimaryKey
    var lineId: Int = 0b1,
    // 第几章的划线
    var chapterIndex: Int = 0,
    // 章节的第几个字符开始
    var startIndex: Int = 0,
    // 本章的第几个字符结束
    var endIndex: Int = 0,
    // 划线的样式
    var lineStyle: Int = LineStyle.SHAPE,
    // 划线颜色
    var lineColor: Int = LineColor.BLUE,
) : Parcelable {


    override fun hashCode(): Int {
        return lineId.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is DrawLineEntity) return false
        return lineId == other.lineId &&
                chapterIndex == other.chapterIndex &&
                startIndex == other.startIndex &&
                endIndex == other.endIndex &&
                lineStyle == other.lineStyle &&
                lineColor == other.lineColor
    }

    fun getLineColorRes() = when (lineColor) {
        LineColor.BLUE -> R.color.md_blue_200
        LineColor.GREEN -> R.color.md_green_600
        LineColor.ORANGE -> R.color.md_orange_600
        LineColor.YELLOW -> R.color.md_yellow_600
        else -> R.color.md_blue_200
    }

    object LineColor {
        const val BLUE: Int = 0     // 蓝色（默认）
        const val ORANGE: Int = 1   // 橙色
        const val YELLOW: Int = 2   // 黄色
        const val GREEN: Int = 3    // 绿色
    }

    object LineStyle {
        const val STEEP = 0 // 直线
        const val WAVE = 1  // 波浪线
        const val SHAPE = 2 // 选中样式
    }


}