import TimeInterval.WEEK
import TimeInterval.YEAR
import TimeInterval.DAY

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

operator fun TimeInterval.times(times: Int) = MultipliedTimeInterval(this, times)

class MultipliedTimeInterval(val timeInterval: TimeInterval, val times: Int)


operator fun MyDate.plus(timeInterval: TimeInterval): MyDate = this.addTimeIntervals(timeInterval, 1)
operator fun MyDate.plus(multipliedTimeInterval: MultipliedTimeInterval): MyDate =
    this.addTimeIntervals(multipliedTimeInterval.timeInterval, multipliedTimeInterval.times)

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
