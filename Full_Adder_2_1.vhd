LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY Full_Adder_2_1 IS
PORT(
	A,B,Cin : IN std_logic;
	S, Cout : OUT std_logic
);
END Full_Adder_2_1;

ARCHITECTURE Behavior OF Full_Adder_2_1 IS
Signal win: std_logic_vector(0 TO 2);
Signal wout : std_logic_vector(0 TO 1);
BEGIN
	win <= A & B & Cin;
	
	with win select
		wout <=	"00" when "000",
					"10" when "001",
					"10" when "010",
					"01" when "011",
					"10" when "100",
					"01" when "101",
					"01" when "110",
					"11" when "111";
	S <= wout(0);
	Cout <= wout(1);
END Behavior;