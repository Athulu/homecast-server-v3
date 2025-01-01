DROP TRIGGER IF EXISTS setting_change_notify_trigger ON public.setting;

CREATE TRIGGER setting_change_notify_trigger
    AFTER INSERT OR UPDATE OR DELETE
    ON public.setting
    FOR EACH ROW EXECUTE FUNCTION public.setting_change_notify();