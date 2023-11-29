import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/zelda")
public class ZeldaController {

    private final ZeldaAPIService zeldaAPIService;

    @Autowired
    public ZeldaController(ZeldaAPIService zeldaAPIService) {
        this.zeldaAPIService = zeldaAPIService;
    }

    @GetMapping("/games/{gameId}")
    public ZeldaGame getGameInfo(@PathVariable int gameId) {
        return zeldaAPIService.getGameInfo(gameId);
    }


}
