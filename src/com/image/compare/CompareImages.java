
package com.image.comapre;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CompareImages {
	
	public static void main(String[] args) throws IOException {
	
		long start = System.currentTimeMillis();
		int q = 0;
		File textFile = new File("E:\\Workspace\\SwingExmples\\src\\com\\image\\comapre\\filename.txt");
		/* if file doesnt exists, then create it*/
		if (!textFile.exists())
		{
			textFile.createNewFile();
		}
		
		//Get the source Image
		File sourceImage = new File("E:\\Workspace\\SwingExmples\\images\\type 2 diabetes suffering from foot ulcers 2.jpg");
		System.out.println("Getting Source Image : " + sourceImage.getName());
		if (!sourceImage.exists())
		{
			System.err.println("Source Image Not Found At : " + sourceImage.getPath());
			return;
		}
		
		//Create A Buffered Image Object Of Source Image
		BufferedImage bufferedSourceImage = ImageIO.read(sourceImage);
		int width = bufferedSourceImage.getWidth(null);
		int height = bufferedSourceImage.getHeight(null);
		int[][] clr = new int[width][height];
		
		//Get the target image
		File targetImage = new File("E:\\Workspace\\SwingExmples\\images\\type 2 diabetes suffering from foot ulcers3.jpg");
		System.out.println("Getting Target Image : " + targetImage.getName());
		if (!targetImage.exists())
		{
			System.err.println("Target Image Not Found At : " + targetImage.getPath());
			return;
		}
		
		//Create A Buffered Image Object Of Target Image
		BufferedImage bufferedTargetImage = ImageIO.read(targetImage);
		int widthe = bufferedTargetImage.getWidth(null);
		int heighte = bufferedTargetImage.getHeight(null);
		int[][] clre = new int[widthe][heighte];
		int smallestWidth = 0;
		int smallestHeight = 0;
		int p = 0;
		
		//Create File Writer and Buffered Writer Object
		FileWriter fileWriter = new FileWriter(textFile.getAbsoluteFile());
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		//CALUCLATING THE SMALLEST VALUE AMONG WIDTH AND HEIGHT
		System.out.println("-----------------------------------------------------------");
		System.out.println("CALUCLATING THE SMALLEST VALUE AMONG WIDTH AND HEIGHT:");
		if (width > widthe)
		{
			smallestWidth = widthe;
		}
		else
		{
			smallestWidth = width;
		}
		if (height > heighte)
		{
			smallestHeight = heighte;
		}
		else
		{
			smallestHeight = height;
		}
		System.out.println("Smallest Width : " + smallestWidth);
		System.out.println("Smallest Height : " + smallestHeight);
		System.out.println("-----------------------------------------------------------");
		//CHECKING NUMBER OF PIXELS SIMILARITY
		System.out.println("CHECKING NUMBER OF PIXELS SIMILARITY");
		System.out.println("------------------------------------------------------------");
		for (int a = 0; a < smallestWidth; a++)
		{
			for (int b = 0; b < smallestHeight; b++)
			{
				clre[a][b] = bufferedTargetImage.getRGB(a, b);
				clr[a][b] = bufferedSourceImage.getRGB(a, b);
				if (clr[a][b] == clre[a][b])
				{
					p = p + 1;
					bufferedWriter.write("\t");
					bufferedWriter.write(Integer.toString(a));
					bufferedWriter.write("\t");
					bufferedWriter.write(Integer.toString(b));
					bufferedWriter.write("\n");
				}
				else
					q = q + 1;
			}
		}
		float w, h = 0;
		if (width > widthe)
		{
			w = width;
		}
		else
		{
			w = widthe;
		}
		if (height > heighte)
		{
			h = height;
		}
		else
		{
			h = heighte;
		}
		System.out.println("Width : " + w + " Height : " + h);
		System.out.println("------------------------------------------------------------");
		bufferedWriter.close();
		
		float s = (smallestWidth * smallestHeight);
		
		System.out.println("CALUCLATING PERCENTAGE :");
		//CALUCLATING PERCENTAGE
		float x = (100 * p) / s;
		System.out.println("THE PERCENTAGE SIMILARITY IS APPROXIMATELY =" + x + "%");
		long stop = System.currentTimeMillis();
		System.out.println("TIME TAKEN IS =" + (stop - start));
		System.out.println("NO OF PIXEL GETS VARIED:=" + q);
		System.out.println("NO OF PIXEL GETS MATCHED:=" + p);
	}
}
