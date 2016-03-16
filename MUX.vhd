LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- Done
ENTITY MUX IS
PORT(
	Sel: IN std_logic_vector(0 TO 4);
	G: IN std_logic_vector(0 TO 15);
	DIN: IN std_logic_vector(0 TO 15);
	R0: IN std_logic_vector(0 TO 15);
	R1: IN std_logic_vector(0 TO 15);
	R2: IN std_logic_vector(0 TO 15);
	R3: IN std_logic_vector(0 TO 15);
	R4: IN std_logic_vector(0 TO 15);
	R5: IN std_logic_vector(0 TO 15);
	R6: IN std_logic_vector(0 TO 15);
	R7: IN std_logic_vector(0 TO 15);
	B:OUT std_logic_vector(0 TO 15)
);
END MUX;
	
ARCHITECTURE Behavior OF MUX IS


BEGIN
	
	with Sel select
		B <= 	G when "10000",
				DIN when "01000",
				R0 when "00000",
				R1 when "00001",
				R2 when "00010",
				R3 when "00011",
				R4 when "00100",
				R5 when "00101",
				R6 when "00110",
				R7 when "00111",
				"1010101111001101" when OTHERS;
END Behavior;