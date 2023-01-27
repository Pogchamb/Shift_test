package pa.chan.shift_test.presentation

enum class CustomError(val message: String) {
    CustomUnknownHostException(message = "Проверьте ваше подключение к интернету"),
    CustomHttpException(message = "Kарта не найдена")
}