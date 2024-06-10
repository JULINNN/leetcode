import java.util.*;

public class DestinationCity_1436 {

  public static void main(String[] args) {

    List<List<String>> lists =
        List.of(
            List.of("jMgaf WaWA", "iinynVdmBz"),
            List.of("QCrEFBcAw", "wRPRHznLWS"),
            List.of("iinynVdmBz", "OoLjlLFzjz"),
            List.of("OoLjlLFzjz", "QCrEFBcAw"),
            List.of("IhxjNbDeXk", "jMgaf WaWA"),
            List.of("jmuAYy vgz", "IhxjNbDeXk"));

    destCity(lists);
  }

  public static String destCity(List<List<String>> paths) {
    Map<String, String> map = new HashMap<>();
    for (List<String> path : paths) {
      map.putIfAbsent(path.get(0), "k");
      map.put(path.get(1), map.getOrDefault(path.get(1), "") + "v");
    }
    return map.entrySet().stream().filter(v -> v.getValue().equals("v")).findFirst().get().getKey();
  }
}
