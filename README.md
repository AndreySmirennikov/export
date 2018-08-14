Проект export решает следуйщие задания:
 
Задание 1

Напишите тесты для модуля возвращающего треугольники:

/**
* Factory returning random triangles.
*/
public interface TriangleFactory {
 /**
  * @return a triangle
  */
 Polygon getTriangle();
}

Треугольники представлены экземплярами класса Polygon, содержащим несколько вершин:

public final class Polygon {
 public final Vertex[] vertices;

 public Polygon(Vertex... vertices) {
   this.vertices = vertices;
 }
}

public final class Vertex {
 public final int x;
 public final int y;

 public Vertex(int x, int y) {
   this.x = x;
   this.y = y;
 }
}

Разработчики все еще трудятся над конкретной реализацией TriangleFactory, поэтому для тестирования Вам предлагается использовать собственную заглушку.

Исходный код модуля содержится в модуле triangles.

Задание 2
Компания Сегменто заботится о своих сотрудниках, и для поддержания уверенности в их комфорте решено автоматизировать проверку наличия как минимум двух кафе, одного бара и остановки общественного транспорта в 5 минутах ходьбы (400 метров) от офиса компании (координаты: 59.93823555,30.2668659740719).
Для проверки выполнения всех перечисленных условий необходимо использовать Overpass API [1]. Данный API позволяет выполнять запросы к данным OpenStreetMaps и получать ответ в виде множества сущностей. В рамках данной задачи необходимо использовать только одну из них - Node (далее - узел). Каждый узел содержит координаты (широту и долготу), а также множество меток (tags), представляющих собой пары ключ-значение и кодирующие информацию об узле. Например, ангар в аэропорту будет закодирован меткой aeroway со значением hangar. Подробнее со списком допустимых меток и их значений можно ознакомиться на wiki проекта OSM [2].
Overpass API позволяет запрашивать узлы удовлетворяющие нескольким критериям. Например, так будет выглядеть запрос для получения всех магазинов в радиусе километра от московского кремля: 

http://overpass-api.de/api/interpreter?data=[out:json];node(around:1000,55.752121,37.617664)[shop~%22.*%22];out;

Пример ответа:
{
  "version": 0.6,  "generator": "Overpass API",
  "osm3s": {
    "timestamp_osm_base": "2017-07-24T08:10:02Z",
    "copyright": "The data included in this document is from www.openstreetmap.org. The data is made available under ODbL."
  },
  "elements": [

{
  "type": "node",
  "id": 906872238,
  "lat": 55.7589727,
  "lon": 37.6173546,
  "tags": {
    "name": "Надин",
    "opening_hours": "Mo-Fr 09:00-21:00; Sa,Su 10:00-21:00",
    "shop": "tea"
  }
},
…
}
.

С подробным описанием языка запросов и примерами запросов можно ознакомиться на wiki: [3], [4].

Тесты должны использовать один из публичных Overpass API серверов:
http://overpass-api.de/api/interpreter
http://overpass.osm.rambler.ru/cgi/interpreter

Если какой-то из серверов недоступен, тесты должны использовать любой другой.

Подсказка: остановки общественного транспорта кодируются с помощью меток public_transport=platform.

[1] http://wiki.openstreetmap.org/wiki/Overpass_API
[2] http://wiki.openstreetmap.org/wiki/Map_Features#Aeroway
[3] http://wiki.openstreetmap.org/wiki/Overpass_API/Language_Guide
[4] http://wiki.openstreetmap.org/wiki/Overpass_API/Overpass_API_by_Example
