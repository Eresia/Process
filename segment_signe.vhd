LIBRARY ieee;
USE ieee.std_logic_1164.all;

-- Done
ENTITY segment_signe IS
PORT(
	C: IN std_logic;
	O: OUT std_logic_vector(0 TO 6)
);
END segment_signe;

ARCHITECTURE Behavior OF segment_signe IS
--Signal win: std_logic_vector(0 TO 0);
Signal wout: std_logic_vector(0 TO 6);
BEGIN
	--win <= C;
	with C select
		wout <= 	"1111111" when '0',
					"1111110" when '1';
		O <= wout;
END Behavior;