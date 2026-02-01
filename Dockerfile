# Use official Playwright Java image
FROM mcr.microsoft.com/playwright/java:v1.41.2-jammy

# Set working directory
WORKDIR /app

# Copy Maven files first (for layer caching)
COPY pom.xml .
COPY testing.xml .

# Download dependencies
RUN mvn dependency:resolve

# Copy source code
COPY src ./src

# Run tests
CMD ["mvn", "test"]
