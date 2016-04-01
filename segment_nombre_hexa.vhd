LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- Done
ENTITY segment_nombre_hexa IS
PORT(
	C: IN std_logic_vector(0 TO 3);
	O: OUT std_logic_vector(0 TO 6)
);
END segment_nombre_hexa;

ARCHITECTURE Behavior OF segment_nombre_hexa IS
--Signal win: std_logic_vector(0 TO 0);
Signal wout: std_logic_vector(0 TO 6);
BEGIN
	--win <= C;
	with C select
		wout <= 	"0000001" when "0000", --0
					"1001111" when "0001", --1
					"0010010" when "0010", --2
					"0000110" when "0011", --3
					"1001100" when "0100", --4
					"0100100" when "0101", --5
					"0100000" when "0110", --6
					"0001111" when "0111", --7
					"0000000" when "1000", --8
					"0000100" when "1001", --9
					"0001000" when "1010", --A
					"1100000" when "1011", --B
					"0001101" when "1100", --C
					"1000010" when "1101", --D
					"0110000" when "1110", --E
					"0111000" when "1111"; --F
		O <= wout;
END Behavior;