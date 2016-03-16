LIBRARY ieee; USE ieee.std_logic_1164.all;
USE ieee.std_logic_signed.all;

-- Done
ENTITY Demux IS
PORT(
	I: IN std_logic_vector(0 TO 2);
	O: OUT std_logic_vector(0 TO 7)
);
END Demux;

Architecture Behavior OF Demux IS

BEGIN
	with I select
		O <= 	"10000000" when "000",
				"01000000" when "001",
				"00100000" when "010",
				"00010000" when "011",
				"00001000" when "100",
				"00000100" when "101",
				"00000010" when "110",
				"00000001" when "111";
END Behavior;