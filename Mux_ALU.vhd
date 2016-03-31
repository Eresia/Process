LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- Done
ENTITY MUX_ALU IS
GENERIC(SIZE : positive := 16);
PORT(
	A,B,C,D,E,F,G,H : IN std_logic_vector(0 TO SIZE-1) := (others => '0');
	Sel: IN std_logic_vector(0 TO 2);
	O : OUT std_logic_vector(0 TO SIZE-1)
);
END MUX_ALU;
	
ARCHITECTURE Behavior OF MUX_ALU IS

BEGIN
	with Sel select
		O <= 	A when "000",
				B when "001",
				C when "010",
				D when "011",
				E when "100",
				F when "101",
				G when "110",
				H when "111";
				
END Behavior;