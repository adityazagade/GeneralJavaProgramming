public class Client_producer {
    public static void main(String[] args) {
        SimpleMessageProducer smp = new SimpleMessageProducer(SharedConstants.QUEUE_NAME, SharedConstants.URL1);
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            smp.sendMessage("Hello, this is aditya: " + i);
        }
    }
}
