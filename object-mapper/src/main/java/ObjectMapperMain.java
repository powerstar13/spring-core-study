import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class ObjectMapperMain {

    public static void main(String[] args) throws JsonProcessingException {

        System.out.println("===== Object Mapper Main =====");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11가 1111");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22가 2222");
        car2.setType("SUV");

        List<Car> cars = Arrays.asList(car1, car2);
        user.setCars(cars);

        String json = objectMapper.writeValueAsString(user);
        System.out.println(json);

        System.out.println("===== Json의 값을 바꾸기 위해 꺼내는 방법 =====");

        JsonNode jsonNode = objectMapper.readTree(json); // 문자열 Json 파싱하기
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();
        System.out.println("_name = " + _name);
        System.out.println("_age = " + _age);

        JsonNode carsNode = jsonNode.get("cars"); // 배열의 경우 JsonNode로 받을 수 있다.
        ArrayNode arrayNode = (ArrayNode) carsNode;

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<>() {}); // Object로 컨버팅 해준다.
        System.out.println("_cars = " + _cars);

        // JsonNode에서는 setter를 막아놨기 때문에 ObjectNode로 형변환 후 사용할 수 있다.
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "이름변경");
        objectNode.put("age", 20);

        System.out.println(objectNode.toPrettyString()); // Json을 예쁘게 출력시켜주는 toPrettyString() 메서드
    }
}
