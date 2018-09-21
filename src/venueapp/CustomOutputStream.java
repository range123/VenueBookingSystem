package venueapp;

import java.io.*;
public class CustomOutputStream extends ObjectOutputStream {

	  public CustomOutputStream(OutputStream out) throws IOException {
	    super(out);
	  }

	  @Override
	  protected void writeStreamHeader() throws IOException {
	    reset();
	  }

	}