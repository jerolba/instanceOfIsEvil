package com.funius.instanceofevil;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.TestCase;

import com.funius.instanceofevil.template.Repository;
import com.funius.instanceofevil.xx.HasXX;
import com.funius.instanceofevil.yy.HasYY;
import com.funius.instanceofevil.zz.HasZZ;

public class ProbarTest extends TestCase {

	private Printer printer;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		printer = new Printer(new Contexto(), new Repository());
	}

	public void testXX() throws Exception {
		String actual = captureOutput(new Runnable() {
			@Override
			public void run() {
				HasXX xx = new HasXX();
				printer.print(xx);
			}
		});
		assertEquals("Imprimiento con XXPrint\n", actual);
	}

	public void testYY1() throws Exception {
		String actual = captureOutput(new Runnable() {
			@Override
			public void run() {
				HasYY yy1 = new HasYY(-1);
				printer.print(yy1);
			}
		});
		assertEquals("Imprimiento con YYPrint1\n", actual);
	}

	public void testYY2() throws Exception {
		String actual = captureOutput(new Runnable() {
			@Override
			public void run() {
				HasYY yy2 = new HasYY(1);
				printer.print(yy2);
			}
		});
		assertEquals("Imprimiento con YYPrint2\n", actual);
	}

	public void testYY3() throws Exception {
		String actual = captureOutput(new Runnable() {
			@Override
			public void run() {
				HasYY yy3 = new HasYY(10, "template1");
				printer.print(yy3);
			}
		});
		assertEquals("Imprimiento con TemplatePrint\n", actual);
	}

	public void testZZ() throws Exception {
		String actual = captureOutput(new Runnable() {
			@Override
			public void run() {
				HasZZ zz = new HasZZ() {

					@Override
					public String getId() {
						return null;
					}

					@Override
					public void setId(String id) {
					}
					
					@Override
					public void accept(Visitor visitor) {
						visitor.visit(this);
					}
				};
				printer.print(zz);
			}
		});
		assertEquals("", actual);
	}
	
	public void testXXandZZ() throws Exception {
		String actual = captureOutput(new Runnable() {
			@Override
			public void run() {
				HasXXandZZ xxWithZZ = new HasXXandZZ();
				printer.print(xxWithZZ);
			}
		});
		assertEquals("", actual);
	}

	public String captureOutput(Runnable r) throws Exception {
		PrintStream out = System.out;
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
			System.setOut(new PrintStream(buffer));
			r.run();
			return new String(buffer.toByteArray(), "utf8");
		} finally {
			System.setOut(out);
		}
	}

}
