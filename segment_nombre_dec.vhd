LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- Done
ENTITY segment_nombre_dec IS
PORT(
	C: IN Integer;
	O: OUT std_logic_vector(0 TO 6)
);
END segment_nombre_dec;

ARCHITECTURE Behavior OF segment_nombre_dec IS
--Signal win: std_logic_vector(0 TO 0);
Signal wout: std_logic_vector(0 TO 6);
BEGIN
	--win <= C;
	with C select
		wout <= 	"0000001" when 0, --0
					"1001111" when 1, --1
					"0010010" when 2, --2
					"0000110" when 3, --3
					"1001100" when 4, --4
					"0100100" when 5, --5
					"0100000" when 6, --6
					"0001111" when 7, --7
					"0000000" when 8, --8
					"0000100" when 9, --9
					"0001000" when 10, --A
					"1100000" when 11, --B
					"0001101" when 12, --C
					"1000010" when 13, --D
					"0110000" when 14, --E
					"0111000" when 15, --F
					"0111111" when OTHERS; --Inconnu
		O <= wout;
END Behavior;