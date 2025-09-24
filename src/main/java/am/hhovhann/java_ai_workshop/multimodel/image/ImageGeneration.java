package am.hhovhann.java_ai_workshop.multimodel.image;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ImageGeneration {
    private final ChatClient chatClient;
    private final OpenAiImageModel openAiImageModel;

    public ImageGeneration(ChatClient chatClient, OpenAiImageModel openAiImageModel) {
        this.chatClient = chatClient;
        this.openAiImageModel = openAiImageModel;
    }

    @GetMapping("/generate-image")
    public ResponseEntity<Map<String, String>> generateImage(@RequestParam(defaultValue = "A beautiful sunset over mountains") String prompt) {
        OpenAiImageOptions imageOptions = OpenAiImageOptions.builder()
                .model("dall-e-3")
                .quality("hd")
                .N(1)
                .height(1024)
                .width(1024)
                .style("vivid") // or natural
                .build();

        ImagePrompt imagePrompt = new ImagePrompt("A light cream colored mini golden doodle", imageOptions);
        ImageResponse imageResponse = openAiImageModel.call(imagePrompt);

        return ResponseEntity.ok(Map.of("prompt", prompt, "imageUrl", imageResponse.getResult().getOutput().getUrl()));
    }
}
