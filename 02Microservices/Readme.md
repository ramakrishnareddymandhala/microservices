Spring cloud Config server
Dynamic Refresh
  Simualte Git webhook command

  >curl -v  POST "http://localhost:8888/monitor" -H "Content-Type: application/json" -H "X-Event-Key: repo:push" -H "X-Hook-UUID: webhook-uuid" -d "{\"push\": {\"changes\": []} }"


Setup Zipkin
1. Start Rabbit Mq
2. Start Zipkin
  java -jar zipkin-server-2.23.2-exec.jar RABBIT_URI=amqp://localhost
