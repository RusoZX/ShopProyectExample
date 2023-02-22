package shopServer;

/**
 *
 * @author RusoZX
 */
import io.grpc.netty.NettyServerBuilder;
import io.netty.handler.ssl.ClientAuth;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import shopServer.Services.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.net.ssl.SSLException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ShopServer {

    io.grpc.Server srv;
    int port;
    //We create the constructor of the server in wich we indicate the port and the services that it will use
    public ShopServer(int port){
        this.port = port;
        srv = ServerBuilder.forPort(port)
                .addService(new UserDataService())
                .addService(new AddUserService())
                .addService(new ProductDataService())
                .addService(new AddRestockService())
                .addService(new AddSaleService())
                .addService(new AddProductService())
                .addService(new GetRestocksService())
                .addService(new GetSalesService())
                .addService(new GetProductsService())
                .addService(new ChangeUserService())
                .addService(new LoginService())
                .addService(new IsLikedService())
                .addService(new LikesListService())
                .addService(new CategoriesService())
                .addService(new GetShoppingListService())
                .addService(new ChangePwdService())
                .build();
    }
    public ShopServer(int port,SslContext sslContext){
        this.port = port;
        srv = NettyServerBuilder.forPort(port)
                .sslContext(sslContext)
                .addService(new UserDataService())
                .addService(new AddUserService())
                .addService(new ProductDataService())
                .build();
    }
    //Here we create a method to start the server
    private void start() {
        try {
            srv.start();
            System.out.println("Starting the server listening to the  "+port +" port");
            srv.awaitTermination();
        } catch (InterruptedException ex) {
            Logger.getLogger(ShopServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(ShopServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Here we create a method to shutdown the server
    private void stop() {
        srv.shutdown();
    }
    //Here we create a method for the server to work until shutdown
    private void blockUntilShutdown() {
        try {
            srv.awaitTermination();
        } catch (InterruptedException ex) {
            Logger.getLogger(ShopServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static SslContext loadTLSCredentials() throws SSLException{
        SslContext sslContext;

        File serverCertFile = new File("cert/certificate.pem");
        File serverKeyFile = new File("cert/privatekey.pem");

        sslContext = SslContextBuilder.forServer(serverCertFile, serverKeyFile)
                .clientAuth(ClientAuth.NONE).build();
        return sslContext;
        /*}catch (SSLException sslEx){
            System.out.println("//////////////////////////SSL ERROR//////////////////////////////\n"+
                    sslEx.getMessage());
        }*/

    }
    //Here we start the server
    public static void main(String[] args) {
        ShopServer server = new ShopServer(9090);

        server.start();
        server.blockUntilShutdown();
    }
    
}
