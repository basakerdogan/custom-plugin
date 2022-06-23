package com.basak.summarize;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteOutputFile {


	public static void writeOutput(String path, String data) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(data);
		writer.close();
	}
}
