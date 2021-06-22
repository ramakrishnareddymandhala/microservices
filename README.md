# Microservices
Microservices using Spring boot and Spring cloud

Simualte Git webhook command
curl -v  POST "http://localhost:8888/monitor" -H "Content-Type: application/json" -H "X-Event-Key: repo:push" -H "X-Hook-UUID: webhook-uuid" -d "{\"push\": {\"changes\": []} }"
