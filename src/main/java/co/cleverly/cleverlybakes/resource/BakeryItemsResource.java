package co.cleverly.cleverlybakes.resource;
import co.cleverly.cleverlybakes.model.BakeryItems;
import co.cleverly.cleverlybakes.model.Response;
import co.cleverly.cleverlybakes.service.BakeryItemsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/cleverlyBakery")
@RequiredArgsConstructor
public class BakeryItemsResource {

    private final BakeryItemsServiceImpl bakeryItemsService;

    @GetMapping("/list")
    public ResponseEntity<Response> getBakeryItems(){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Bakery ITems", bakeryItemsService.list(30)))
                        .message("Bakery ITems Rtrieved")
                        .statusCode(OK.value())
                        .status(OK)
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveBakeryItem(@RequestBody @Valid BakeryItems bakeryItem){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Bakery Item", bakeryItemsService.create(bakeryItem)))
                        .message("Bakery Item Saved")
                        .statusCode(OK.value())
                        .status(OK)
                        .build()
        );
    }

    @GetMapping("/get/{itemId}")
    public ResponseEntity<Response> getBakeryItem(@PathVariable("itemId") Long itemId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Bakery Item", bakeryItemsService.get(itemId)))
                        .message("Bakery Item Retrieved")
                        .statusCode(OK.value())
                        .status(OK)
                        .build()
        );
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Response> deleteBakeryItem(@PathVariable("itemId") Long itemId){
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("Bakery Item", bakeryItemsService.deleteItem(itemId)))
                        .message("Bakery Item Deleted")
                        .statusCode(OK.value())
                        .status(OK)
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = IMAGE_PNG_VALUE)
    public byte[] getServerImage(@PathVariable("fileName") String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images/" + fileName)
        );
    }

}
