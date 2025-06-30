package org.wildfly.ai.a2a.weather;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import io.smallrye.llm.spi.RegisterAIService;
import jakarta.enterprise.context.ApplicationScoped;

@RegisterAIService(toolProviderName = "mcp-stdio", chatModelName = "gemini", scope = ApplicationScoped.class)
public interface WeatherAgent {

    @SystemMessage("""
            You are a specialized weather forecast assistant. Your primary function is to utilize the provided tools to
            retrieve and relay weather information in response to user queries. You must rely exclusively on these tools
            for data and refrain from inventing information. Ensure that all responses include the detailed output from
            the tools used and are formatted in Markdown.
            """
    )
    String chat(@UserMessage String question);
}