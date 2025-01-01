CREATE OR REPLACE FUNCTION setting_change_notify()
RETURNS TRIGGER AS $$
BEGIN
    IF (TG_OP = 'INSERT') THEN
        PERFORM pg_notify(
            'settings_changes_channel',
            json_build_object(
                'operation', 'INSERT',
                'property', NEW.property,
                'value', NEW.value,
                'description', OLD.description
            )::text
        );

    ELSIF (TG_OP = 'UPDATE') THEN
        PERFORM pg_notify(
            'settings_changes_channel',
            json_build_object(
                'operation', 'UPDATE',
                'old_property', OLD.property,
                'new_property', NEW.property,
                'old_value', OLD.value,
                'new_value', NEW.value,
                'old_description', OLD.description,
                'new_description', NEW.description
            )::text
        );

    ELSIF (TG_OP = 'DELETE') THEN
        PERFORM pg_notify(
            'settings_changes_channel',
            json_build_object(
                'operation', 'DELETE',
                'property', OLD.property,
                'value', OLD.value,
                'description', OLD.description
            )::text
        );
    END IF;

    RETURN NULL;
END;
$$ LANGUAGE plpgsql;