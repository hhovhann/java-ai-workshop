package am.hhovhann.java_ai_workshop.config;

//import org.springframework.ai.anthropic.AnthropicChatModel;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AiConfiguration {

    @Bean
    public ChatClient openAIChatClient(OpenAiChatModel openAiChatModel) {
        return ChatClient.create(openAiChatModel);
    }

//    @Bean
//    public ChatClient anthropicAIChatClient(AnthropicChatModel anthropicChatChatModel) {
//        return ChatClient.create(anthropicChatChatModel);
//    }
}
