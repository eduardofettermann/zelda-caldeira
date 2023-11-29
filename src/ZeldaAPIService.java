import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ZeldaAPIService {

    private final String ZELDA_API_BASE_URL = "https://zelda-api.apius.cc/api/";

    public ZeldaGame getGameInfo(int gameId) {
        String gameEndpoint = ZELDA_API_BASE_URL + "games/" + gameId;
        RestTemplate restTemplate = new RestTemplate();
        ZeldaGame game = restTemplate.getForObject(gameEndpoint, ZeldaGame.class);
        return game;
    }


}
