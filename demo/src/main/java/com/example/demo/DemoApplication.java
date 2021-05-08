package com.example.demo;
//自作クラス呼び出し
import com.example.view.Scene;
import com.example.view.Scene.SceneName;
import com.example.model.Mino;

//Springクラス呼び出し
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//クラス呼び出し

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args)) {
            DemoApplication app = ctx.getBean(DemoApplication.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

//		SpringApplication.run(DemoApplication.class, args);

	}

	public void run(String... args) throws Exception {
		Scene scene = new Scene();
		Mino mino = new Mino();
		scene.draw(SceneName.TITLE.getId());
		scene.draw(SceneName.FIELD.getId());
		int[][][] draw_mino = mino.get(); 

		for(int y = 0; y < 4; y++ ){
            for(int x = 0; x < 4; x++){
                System.out.printf("%s", ( draw_mino[1][x][y] == 1  ? "■" : "0") );
            }
            System.out.println();//改行
        }


    }

}
