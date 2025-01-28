# language: ru
Функция: Калькулятор для двухзонного тарифа
Сценарий: Рассчёт одного кВт для дневного тарифа и одного кВт для ночного тарифа
Допустим идёт рассчёт одного кВт
И идёт рассчёт одного кВт (ночной)
И рассчёт для сельской местности
И есть газовая плита
К тому же калькулятор вычислил (двухзонный)
Тогда калькулятор вернёт значение 5,3 копейка

Сценарий: Рассчёт одного кВт для дневного тарифа и одного кВт для ночного тарифа (город, есть плита)
Допустим идёт рассчёт одного кВт
И идёт рассчёт одного кВт (ночной)
И рассчёт для города
И есть газовая плита
К тому же калькулятор вычислил (двухзонный)
Тогда калькулятор вернёт значение 7,56 копейка

Сценарий: Рассчёт одного кВт для дневного тарифа и одного кВт для ночного тарифа (город, без плиты)
Допустим идёт рассчёт одного кВт
И идёт рассчёт одного кВт (ночной)
И рассчёт для города
И нет газовой плиты
К тому же калькулятор вычислил (двухзонный)
Тогда калькулятор вернёт значение 5,3 копейка


