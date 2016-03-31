LIBRARY ieee;
USE ieee.std_logic_1164.all;

ENTITY Full_Sub_2_1 IS
PORT(
	A,B,Cin : IN std_logic;
	S, Cout : OUT std_logic
);
END Full_Sub_2_1;

ARCHITECTURE Behavior OF Full_Sub_2_1 IS
Signal win: std_logic_vector(0 TO 2);
Signal wout : std_logic_vector(0 TO 1);
BEGIN
	win <= A & B & Cin;
	
	with win select
		wout <=	"00" when "000",
					"10" when "100",
					"11" when "010",
					"11" when "001",
					"00" when "110",
					"00" when "101",
					"01" when "011",
					"11" when "111";
	S <= wout(0);
	Cout <= wout(1);
END Behavior;