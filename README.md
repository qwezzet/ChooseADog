#ChooseADog
# Выбери собаку
### Всех приветствую на представлении своего проекта!
### Так вышло, что я не смогу на нем присутствовать, но я в любой момент отвечу вам в vk
Я не буду долго рассказывать о том проекте с которым вышел на защиту (которую успешно провалил), но я скажу о том что там было реализовано и какие недочеты были
В предыдущей модели приложения были реализованы : listview, была таблица на 3000 строк, криво работающие фильтры, бесконечный splash screen ( на который вы попадали через кнопку "Выход" ), также не было ни одной подключенной библиотеки, и был плохо реализован интерфейс.  
### Но в новой версии я решил учесть все мои ошибки и пожелания комиссии, и я постарался их исправить!
В моей новой версии приложения вы сможете увидеть кучу изменений : была полностью снесена таблица на 3к элементов, был реализован recyclerview (но listview никуда не делся), таблица теперь заполняется программно (теперь в layout'те меньше 150 строк), были добавлены fragment'ы в коллабе с bottomNavView, была добавлена главная навигационная панель (BottomNavView), были добавлены 2 selector'а, был реализован правильный выход на кноку "Выход", был добавлен imageSwitcher, были добавлены анимации на переходы в ImageSwitcher'е , реализовано наследоввание от 3ех библиотек (recycler, material, material(1.6.0)), была починена проблема с пропажей некоторых пород собак при изменении.

 
